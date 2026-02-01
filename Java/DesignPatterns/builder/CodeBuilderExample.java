import java.util.*;


public class CodeBuilderExample{

    public static void main(String[] args) {
        CodeBuilder cb = new CodeBuilder("Person");
        System.out.println(cb);
    }
}


class CodeBuilder
{

    String root;
    CodeElement rootEle;

    public CodeBuilder(String className)
    {
        // todo
        this.root = className;
        this.rootEle = new CodeElement(null, className);
    }

    public CodeBuilder addField(String name, String type)
    {
        // todo
        this.rootEle.ele.add(new CodeElement(type, name));
        return this;
    }

    @Override
    public String toString()
    {
        // todo
        return this.rootEle.toString();
    }
}

class CodeElement{

    public String type;
    public String name;
    public final int indentSize = 2;
    public final String lineSep = System.lineSeparator();
    List<CodeElement> ele = new ArrayList<>();

    public CodeElement(){}

    public CodeElement(String type, String name){
        this.type = type;
        this.name = name;
    }


    public String toStringImpl(int i){
        StringBuilder sb = new StringBuilder();

        String indent = String.join("", Collections.nCopies(indentSize * i, " "));

        if(this.type == null && this.name != null){
            sb.append(String.format("%spublic class %s%s{%s", indent, name, lineSep, lineSep));
        }
        else if(this.type != null && this.name != null){
            sb.append(String.format("%spublic %s %s;%s", indent, type, name, lineSep));
        }

        for(CodeElement e: ele)
            sb.append(e.toStringImpl(1));

        if(this.type == null) {
            sb.append("}");
        }


        return sb.toString();
    }


    public String toString(){
        return toStringImpl(0);
    }

}
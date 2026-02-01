import java.util.*;

class HtmlElement{
    public String text;
    public String tag;
    public final int indentSize = 2;
    public final String lineSep = System.lineSeparator();
    public List<HtmlElement> elements = new ArrayList<>();

    public HtmlElement() {}

    public HtmlElement(String tag, String text) {
        this.tag = tag;
        this.text = text;
    }

    public String toStringImpl(int indent){
        StringBuilder sb = new StringBuilder();

        String indents = String.join("", Collections.nCopies(indent * indentSize, " "));
        sb.append(String.format("%s<%s>%s", indents, this.tag, this.lineSep));

        if(this.text != null && !this.text.isBlank()){
            String extraIndents = String.join("", Collections.nCopies((indent + 1) * indentSize, " "));
            sb.append(String.format("%s%s%s", extraIndents, this.text, this.lineSep));
        }
        for(HtmlElement ele: elements)
            sb.append(ele.toStringImpl(indent+1));

        sb.append(String.format("%s</%s>%s", indents, this.tag, this.lineSep));

        return sb.toString();
    }


    @Override
    public String toString(){
        return this.toStringImpl(0);
    }
}

class HtmlBuilder{
    String rootName;
    HtmlElement root;

    public HtmlBuilder(String rootName) {
        this.rootName = rootName;
        root = new HtmlElement();
        root.tag = rootName;
    }

    public HtmlBuilder addChild(String tag, String text){
        HtmlElement child = new HtmlElement(tag, text);
        root.elements.add(child);
        return this;
    }

    public String toString(){
        return root.toString();
    }

    public void clear(){
        root = new HtmlElement();
        root.tag = rootName;
    }

}

public class HtmlBuilderExample{
    public static void main(String[] args) {
        HtmlBuilder builder = new HtmlBuilder("ul");
        builder.addChild("li", "Habeeb");
        builder.addChild("li", "Rahman");

        HtmlBuilder top = new HtmlBuilder("html");
        top.

        System.out.println(builder);
    }
}
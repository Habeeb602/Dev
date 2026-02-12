package com.example.reactive.section_4.Util;

import com.example.reactive.common.Util;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class NameGenerator implements Consumer<FluxSink<String>> {

    private FluxSink<String> fluxSink;

    @Override
    public void accept(FluxSink<String> fluxSink) {
        this.fluxSink = fluxSink;
    }

    public void generate(){
        this.fluxSink.next(Util.getFaker().name().fullName());
    }

}

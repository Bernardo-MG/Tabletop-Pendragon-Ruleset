package com.wandrell.tabletop.pendragon.util.outputter;

import org.jdom2.Document;

import com.wandrell.pattern.parser.Parser;
import com.wandrell.tabletop.pendragon.model.inventory.Shield;

public final class ShieldDocumentOutputProcessor implements
        Parser<Shield, Document> {

    public ShieldDocumentOutputProcessor() {
        super();
    }

    @Override
    public final Document parse(final Shield holder) {
        return null;
    }

}

package com.wandrell.tabletop.business.util.parser.xml.pendragon.output;

import org.jdom2.Document;

import com.wandrell.tabletop.business.model.pendragon.chargen.FamilyCharacteristicTemplate;
import com.wandrell.util.parser.xml.output.JDOMDocumentEncoder;

public class FamilyCharacteristicDocumentOutputProcessor implements
        JDOMDocumentEncoder<FamilyCharacteristicTemplate> {

    public FamilyCharacteristicDocumentOutputProcessor() {
        super();
    }

    @Override
    public final Document encode(final FamilyCharacteristicTemplate holder) {
        return null;
    }

}

package com.wandrell.tabletop.pendragon.framework.util.file.persistence;

import java.util.LinkedList;

import org.jdom2.Document;
import org.jdom2.Element;

import com.wandrell.tabletop.pendragon.character.DefaultHorseCharacter;
import com.wandrell.tabletop.pendragon.character.HorseCharacter;
import com.wandrell.tabletop.pendragon.framework.conf.FileToken;
import com.wandrell.tabletop.pendragon.valuehandler.Attribute;
import com.wandrell.tabletop.util.XMLUtil;
import com.wandrell.util.file.api.xml.XMLDocumentReader;

public class HorseXMLDocumentReader implements
	XMLDocumentReader<HorseCharacter> {

    public HorseXMLDocumentReader() {
	super();
    }

    @SuppressWarnings("unused")
    @Override
    public final HorseCharacter getValue(final Document doc) {
	final DefaultHorseCharacter holder;
	final Element secAttributes, flags;
	final Element root;

	root = doc.getRootElement();

	holder = new DefaultHorseCharacter(new LinkedList<Attribute>());

	// TODO
	// PersistenceFactory.getCharacterService().addToBaseCharacter(root,
	// holder);

	// Acquires the different sections
	secAttributes = root.getChild(FileToken.SECONDARY_ATTRIBUTES);
	flags = root.getChild(FileToken.FLAGS);

	// Horse race
	holder.setHorseType(root.getChildText(FileToken.RACE));

	// Secondary attributes
	// TODO
	// holder.setSecondaryAttributes(XMLUtils.readIntegerValueHandlerXMLTree(
	// secAttributes, new IntegerValueHandler()));

	// Flags
	holder.setFlags(XMLUtil.readBooleanXMLTree(flags));

	return holder;
    }

}

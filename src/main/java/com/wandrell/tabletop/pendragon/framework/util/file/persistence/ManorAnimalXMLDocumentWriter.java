package com.wandrell.tabletop.pendragon.framework.util.file.persistence;

import java.util.Map.Entry;

import org.jdom2.Document;
import org.jdom2.Element;

import com.wandrell.tabletop.conf.FileStreamerTags;
import com.wandrell.tabletop.dice.DefaultRollTable;
import com.wandrell.tabletop.interval.ContrastInterval;
import com.wandrell.tabletop.pendragon.framework.conf.FileToken;
import com.wandrell.tabletop.pendragon.manor.AnimalYearResult;
import com.wandrell.tabletop.pendragon.manor.ManorAnimal;
import com.wandrell.tabletop.util.XMLUtil;
import com.wandrell.util.file.api.xml.XMLDocumentWriter;

public class ManorAnimalXMLDocumentWriter implements
	XMLDocumentWriter<ManorAnimal> {

    public ManorAnimalXMLDocumentWriter() {
	super();
    }

    @Override
    public final Document getDocument(final ManorAnimal holder) {
	final Document doc;
	final Element element;

	// Root and pet's name
	element = new Element(FileToken.PET);
	element.setAttribute(FileStreamerTags.NAME, holder.getName());
	doc = new Document(element);

	// Intervals and results
	doc.getRootElement()
		.addContent(
			buildIntervalsXMLTree((DefaultRollTable<AnimalYearResult>) holder
				.getAnnualCheckMap()));

	return doc;
    }

    private final Element buildIntervalsXMLTree(
	    final DefaultRollTable<AnimalYearResult> holder) {
	final Element root;
	Element intervalNode;
	// TODO: Esto se hace en tres clases

	root = new Element(FileToken.INTERVALS);
	for (final Entry<ContrastInterval<Integer>, AnimalYearResult> intervals : holder
		.getIntervals().entrySet()) {
	    intervalNode = XMLUtil.buildIntervalXMLNode(intervals.getKey(),
		    FileStreamerTags.INTERVAL);
	    intervalNode.setAttribute(FileStreamerTags.NAME, intervals
		    .getValue().getName());

	    intervalNode.addContent(buildYearResultNode(intervals.getValue()));
	    root.addContent(intervalNode);
	}

	return root;
    }

    @SuppressWarnings("unused")
    private final Element buildYearResultNode(final AnimalYearResult result) {
	Element node, root;

	root = new Element(FileToken.RESULTS);

	// Values
	// TODO
	// node = XMLUtils.buildIntegerValueHandlerXMLTree(new Element(
	// FileLabels.VALUE_HANDLERS), result.getValuesIterator(),
	// FileLabels.VALUE_HANDLER);
	// if (node.getChildren().size() > 0) {
	// root.addContent(node);
	// }

	// Flags
	// TODO
	// node = XMLUtils.buildBooleansSetXMLTree(new
	// Element(FileLabels.FLAGS),
	// result.getFlagsIterator());
	// if (node.getChildren().size() > 0) {
	// root.addContent(node);
	// }

	// Files
	// TODO
	// node = XMLUtils.buildStringsDictionaryXMLTree(new Element(
	// FileLabels.SELECTORS_FILES), result.getFilesIterator(),
	// FileLabels.FILE);
	// if (node.getChildren().size() > 0) {
	// root.addContent(node);
	// }

	return root;
    }

}
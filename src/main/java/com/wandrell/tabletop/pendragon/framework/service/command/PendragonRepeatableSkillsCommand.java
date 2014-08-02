package com.wandrell.tabletop.pendragon.framework.service.command;

import java.nio.file.Paths;
import java.util.Collection;

import com.wandrell.framework.command.ReturnCommand;
import com.wandrell.tabletop.pendragon.framework.conf.FileToken;
import com.wandrell.tabletop.pendragon.framework.conf.ModelFile;
import com.wandrell.tabletop.pendragon.framework.util.file.model.SkillXMLDocumentReader;
import com.wandrell.tabletop.pendragon.valuehandler.Skill;
import com.wandrell.util.PathUtils;
import com.wandrell.util.file.api.FileHandler;
import com.wandrell.util.file.impl.xml.DefaultXMLFileHandler;
import com.wandrell.util.file.impl.xml.DisabledXMLWriter;
import com.wandrell.util.file.impl.xml.XSDValidator;

public final class PendragonRepeatableSkillsCommand implements
	ReturnCommand<Collection<Skill>> {

    public PendragonRepeatableSkillsCommand() {
	super();
    }

    @Override
    public final Collection<Skill> execute() {
	final FileHandler<Collection<Skill>> file;
	final SkillXMLDocumentReader reader;

	reader = new SkillXMLDocumentReader();
	reader.addRequiredAttribute(FileToken.REPEAT);

	file = new DefaultXMLFileHandler<>(
		new DisabledXMLWriter<Collection<Skill>>(), reader,
		new XSDValidator(PathUtils.getClassPathResource(Paths
			.get(ModelFile.VALIDATION_SKILL))));

	return file.read(PathUtils.getClassPathResource(Paths
		.get(ModelFile.SKILL)));
    }

}

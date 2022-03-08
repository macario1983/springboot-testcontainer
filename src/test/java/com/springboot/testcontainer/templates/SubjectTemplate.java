package com.springboot.testcontainer.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.springboot.testcontainer.dto.SubjectDTO;

public class SubjectTemplate implements TemplateLoader {

    @Override
    public void load() {

        Fixture.of(SubjectDTO.class).addTemplate("valid", new Rule() {{
            add("name", random("Ethics",
                    "French",
                    "History",
                    "Latin",
                    "Latin American and Iberian Studies",
                    "Leadership Studies",
                    "Mathematics",
                    "Media Studies",
                    "Philosophy",
                    "Political Science",
                    "Psychology",
                    "Religious Studies",
                    "Sociology",
                    "Spanish"));
        }});
    }
}

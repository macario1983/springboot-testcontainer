package com.springboot.testcontainer.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.springboot.testcontainer.dto.PersonDTO;
import com.springboot.testcontainer.dto.SubjectDTO;

public class PersonTemplate implements TemplateLoader {

    @Override
    public void load() {

        Fixture.of(PersonDTO.class).addTemplate("valid", new Rule() {{
            add("name", random(
                    "Juniper Lauren",
                    "Salma Valeria",
                    "Julia Rydel",
                    "Nicky Audriana",
                    "Candice Estelle",
                    "Tamra Selena",
                    "Tanisha Bree",
                    "Jemma Sonia",
                    "Catherine Brigid",
                    "Isha Giovanna",
                    "Johanna Kiera",
                    "Elena Roxanne",
                    "Mya Francine",
                    "Cheryl Venus",
                    "Claris Kaelyn",
                    "Naya Isidora",
                    "Becca Stacie",
                    "Clary Sapphire"));
            add("age", random(Short.class, 1, 100));
            add("subjects", has(3).of(SubjectDTO.class, "valid"));
        }});
    }
}

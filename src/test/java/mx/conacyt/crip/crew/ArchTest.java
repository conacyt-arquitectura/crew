package mx.conacyt.crip.crew;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("mx.conacyt.crip.crew");

        noClasses()
            .that()
                .resideInAnyPackage("mx.conacyt.crip.crew.service..")
            .or()
                .resideInAnyPackage("mx.conacyt.crip.crew.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..mx.conacyt.crip.crew.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}

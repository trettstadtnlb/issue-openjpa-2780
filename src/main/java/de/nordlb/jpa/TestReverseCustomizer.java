/*
 * Copyright © NORD/LB Norddeutsche Landesbank Girozentrale, Hannover - Alle Rechte vorbehalten -
 */

package de.nordlb.jpa;

import org.apache.openjpa.jdbc.meta.FieldMapping;
import org.apache.openjpa.jdbc.meta.PropertiesReverseCustomizer;
import org.apache.openjpa.jdbc.meta.strats.EnumValueHandler;

public class TestReverseCustomizer extends PropertiesReverseCustomizer {
  @Override
  public void customize(FieldMapping field) {
    super.customize(field);
    if (field.getDeclaredType().isEnum()) {
      EnumValueHandler enumValueHandler = new EnumValueHandler();
      enumValueHandler.setStoreOrdinal(false);
      field.setHandler(enumValueHandler);
      // As a work-around for the error, we can set the type code to OBJECT to
      // generate the @Enumerated annotation.
//      field.setDeclaredTypeCode(JavaTypes.OBJECT);
    }
  }
}

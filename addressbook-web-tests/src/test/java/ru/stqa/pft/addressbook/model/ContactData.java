package ru.stqa.pft.addressbook.model;

import java.io.File;

/**
 * Created by Андрей on 06.12.2019.
 */
public class ContactData {
  private final String firstname;
  private final String secondname;
  private String group;

  public File withPhoto() {
    return photo;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;

  }

  private File photo;

  public ContactData(String firstname, String secondname, String group) {

    this.firstname = firstname;
    this.secondname = secondname;
    this.group = group;
  }

  public String withFirstname() {
    return firstname;
  }

  public String withLastname() {
    return secondname;
  }

  public String withGroup() {
    return group;
  }
}
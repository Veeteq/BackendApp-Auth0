package com.veeteq.auth0security.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

import com.fasterxml.jackson.annotation.JsonProperty;

@KeySpace("items")
public class Item {
  private final Long id;

  @NotNull(message = "name is required")
  //@Pattern(regexp="^[a-zA-Z ]+$", message = "name must be a string")
  private final String name;

  @NotNull(message = "price is required")
  @Positive(message = "price must be positive")
  private final Long price;

  @NotNull(message = "description is required")
  //@Pattern(regexp="^[a-zA-Z ]+$", message = "description must be a string")
  private final String description;

  @NotNull(message = "image is required")
  @URL(message = "image must be a URL")
  @JsonProperty(value = "image")
  private final String imageUrl;

  public Item(Long id, String name, Long price, String description, String imageUrl) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.description = description;
    this.imageUrl = imageUrl;
  }

  @Id
  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Long getPrice() {
    return price;
  }

  public String getDescription() {
    return description;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public Item updateWith(Item item) {
    return new Item(this.id,
                    item.name,
                    item.price,
                    item.description,
                    item.imageUrl);
  }
}

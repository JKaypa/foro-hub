package com.alura.foro_hub.domain.topic;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Status {
  OPEN("open"),
  CLOSED("closed");

  public final String state;
  Status(String state) {
    this.state = state;
  }

  @Override
  public String toString() {
    return state;
  }

  @JsonCreator
  public static Status fromString(String state) {
    switch (state) {
      case "open":
        return Status.OPEN;
      case "closed":
        return Status.CLOSED;
      default:
        throw new IllegalArgumentException("Invalid status: " + state);
    }
  }
}

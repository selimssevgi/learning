interface ObjBuilder<T> {
  T build();
}

public class ImmutableClassWithBuilder {
  // fields are final
  private final String name;
  private final String surname;

  // constructor is private, internal use only
  private ImmutableClassWithBuilder(Builder builder) {
    name = builder.name;
    surname = builder.surname;
  }

  public static class Builder implements ObjBuilder<ImmutableClassWithBuilder> {
    private String name;
    private String surname;

    public Builder name(String n) {
      name = n;
      return this;
    }

    public Builder surname(String s) {
      surname = s;
      return this;
    }

    @Override
    public ImmutableClassWithBuilder build() {
      return new ImmutableClassWithBuilder(this);
    }
  }

  public static void main(String[] args) {
    ImmutableClassWithBuilder.Builder builder
                    = new ImmutableClassWithBuilder.Builder();

    ImmutableClassWithBuilder immutableObject =
                    builder.name("Immutable").surname("Object").build();
  }
}

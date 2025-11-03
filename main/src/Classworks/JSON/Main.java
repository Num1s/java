package Classworks.JSON;

// File: Main.java
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {
    private static final Path INPUT = Path.of("Input.txt");
    private static final Path OUTPUT = Path.of("Output.txt");

    static class User {
        int id;
        String name;
        String email;
        boolean active;
        List<String> roles;
        String createdAt; // keep as ISO-8601 string for simplicity

        User() {}

        User(int id, String name, String email, boolean active, List<String> roles, String createdAt) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.active = active;
            this.roles = roles;
            this.createdAt = createdAt;
        }
    }

    public static void main(String[] args) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        if (Files.notExists(INPUT)) {
            String sampleJson = """
            {
              "id": 1,
              "name": "John Doe",
              "email": "john.doe@example.com",
              "active": true,
              "roles": ["user","editor"],
              "createdAt": "2025-11-03T10:00:00Z"
            }
            """;
            Files.writeString(INPUT, sampleJson, StandardOpenOption.CREATE_NEW);
        }

        String inputJson = Files.readString(INPUT);
        User fromFile = gson.fromJson(inputJson, User.class);

        User newUser = new User(
                2,
                "Alice Smith",
                "alice.smith@example.com",
                true,
                List.of("admin", "user"),
                "2025-11-03T12:00:00Z"
        );

        String outJson = gson.toJson(newUser);
        Files.writeString(OUTPUT, outJson, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        System.out.println("Deserialized from Input.txt -> User.name = " + fromFile.name);
        System.out.println("Serialized new User -> Output.txt");
    }
}


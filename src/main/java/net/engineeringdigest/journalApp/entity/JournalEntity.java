package net.engineeringdigest.journalApp.entity;

//import jakarta.annotation.Generated;
import lombok.*;
import org.bson.types.ObjectId;
//import org.springframework.aot.generate.GeneratedTypeReference;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "journal_entries")
@Data
@NoArgsConstructor
public class JournalEntity {
    @Id
    private ObjectId id;
    @NonNull
    private String title;
    private String content;
    private LocalDateTime date;

}
//package net.engineeringdigest.journalApp.controller;
//
//import net.engineeringdigest.journalApp.entity.JournalEntity;
//import net.engineeringdigest.journalApp.service.JournalEntryService;
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/journal")
//public class JournalEntryControllerBeforeUserLinked {
//    @Autowired
//    private JournalEntryService journalEntryService;
//
//    // Without HTTP code
////    @GetMapping
////    public List<JournalEntity> getAll() {
////        return journalEntryService.getAll();
////    }
//
//    @GetMapping
//    public ResponseEntity<?> getAll() {
//        List<JournalEntity> all = journalEntryService.getAll();
//        if(all !=null && !all.isEmpty()) {
//            return new ResponseEntity(all, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//    }
//
//
//
//    //    @PostMapping
////    public JournalEntity createEntry(@RequestBody JournalEntity myEntry){
////       myEntry.setDate(LocalDateTime.now());
////
////        journalEntryService.saveEntry(myEntry);
////        return myEntry;
////    }
//    @PostMapping
//    public ResponseEntity<JournalEntity> createEntry(@RequestBody JournalEntity myEntry) {
//        try {
//
//            journalEntryService.saveEntry(myEntry);
//            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(myEntry, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//
//    @GetMapping("/id/{myID}")
//    public ResponseEntity<JournalEntity> getGeneralEntryByID(@PathVariable ObjectId myID) {
//
//        Optional<JournalEntity> journalEntity = journalEntryService.findByID(myID);
//        if (journalEntity.isPresent()) {
//            return new ResponseEntity<>(journalEntity.get(), HttpStatus.OK);
//           // return ResponseEntity.ok(journalEntity.get());
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @DeleteMapping("/id/{myID}")
//    public ResponseEntity<JournalEntity> deleteGeneralEntryByID(@PathVariable ObjectId myID) {
//        journalEntryService.deleteByID(myID);
//       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//
//
//
//// Without HTTP code,
////    @PutMapping("/id/{id}")
////    public JournalEntity updateEntry(@PathVariable ObjectId id,@RequestBody JournalEntity newEntry){
////        JournalEntity oldEntry = journalEntryService.findByID(id).orElse(null);
////        if(oldEntry !=null){
////            oldEntry.setContent(newEntry.getContent()!=null && !newEntry.getContent().equals("") ? newEntry.getContent() : oldEntry.getContent() );
////            oldEntry.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals(("")) ? newEntry.getTitle() : oldEntry.getTitle());
////        }
////        journalEntryService.saveEntry(oldEntry);
////        return oldEntry;
////    }
//
//    // With HTTP code in Postman so we are using ResponseEntity Class
//    @PutMapping("/id/{id}")
//    public ResponseEntity<?> updateEntry(@PathVariable ObjectId id, @RequestBody JournalEntity newEntry) {
//        JournalEntity oldEntry = journalEntryService.findByID(id).orElse(null);
//        if (oldEntry != null) {
//            oldEntry.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : oldEntry.getContent());
//            oldEntry.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals(("")) ? newEntry.getTitle() : oldEntry.getTitle());
//
//            journalEntryService.saveEntry(oldEntry);
//            return new ResponseEntity<>(oldEntry, HttpStatus.OK);
//        }
//        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
//    }
//}
//
//
//
//

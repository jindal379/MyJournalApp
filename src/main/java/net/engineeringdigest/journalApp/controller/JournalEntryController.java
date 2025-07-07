//package net.engineeringdigest.journalApp.controller;
//
//import net.engineeringdigest.journalApp.entity.JournalEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/journal")
//public class JournalEntryController {
//    private Map<Long, JournalEntity> journalEntities= new HashMap<>();
//@GetMapping
//    public List<JournalEntity> getAll(){
//        return new ArrayList<>(journalEntities.values());
//    }
//
//    @PostMapping
//    public boolean createEntry(@RequestBody JournalEntity myEntry){
//        journalEntities.put(myEntry.getId(), myEntry);
//        return true;
//    }
//    @GetMapping ("/id/{myID}")
//    public JournalEntity getGeneralEntryByID(@PathVariable Long myID){
//       return journalEntities.get(myID);
//    }
//
//    @DeleteMapping("/id/{myID}")
//    public JournalEntity deleteGeneralEntryByID(@PathVariable Long myID){
//        return journalEntities.remove(myID);
//    }
//
//    @PutMapping("/id/{id}")
//    public boolean updateEntry(@PathVariable Long id,@RequestBody JournalEntity myEntry){
//        journalEntities.put(id, myEntry);
//        return true;
//    }
//
//
//
//
//}

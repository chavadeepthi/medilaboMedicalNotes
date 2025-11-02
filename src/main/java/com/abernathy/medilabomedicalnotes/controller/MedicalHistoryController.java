package com.abernathy.medilabomedicalnotes.controller;

import com.abernathy.medilabomedicalnotes.model.MedicalHistoryNote;
import com.abernathy.medilabomedicalnotes.service.MedicalHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/notes")  // Adjusted to match gateway routing
public class MedicalHistoryController {

    private final MedicalHistoryService service;

    public MedicalHistoryController(MedicalHistoryService service) {
        this.service = service;
    }

    // POST: /api/notes/history
    @PostMapping("/history")
    public MedicalHistoryNote addNote(@RequestBody MedicalHistoryNote note) {
        log.info("Adding note for Patient ID " + note.getPatientId());
        return service.addNote(
                note.getPatientId(),
                note.getPhysician(),
                note.getNote(),
                note.getPatientName()
        );
    }

    // GET: /api/notes/history?patientId=5
    @GetMapping("/history")
    public List<MedicalHistoryNote> getNotes(@RequestParam Long patientId) {
        log.info("Retrieving notes for Patient ID " + patientId);
        return service.getNotesForPatient(patientId);
    }
}



//package com.abernathy.medilabomedicalnotes.controller;
//
//import com.abernathy.medilabomedicalnotes.model.MedicalHistoryNote;
//import com.abernathy.medilabomedicalnotes.service.MedicalHistoryService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Slf4j
//@RestController
//@RequestMapping("/api/patients/history")
//public class MedicalHistoryController {
//
//    private final MedicalHistoryService service;
//
//    public MedicalHistoryController(MedicalHistoryService service) {
//        this.service = service;
//    }
//
//    // POST: /api/patients/history?patientId=5
//    @PostMapping
//    public MedicalHistoryNote addNote(@RequestBody MedicalHistoryNote note) {
//        log.info("Adding note for Patient ID " + note.getPatientId());
//        return service.addNote(note.getPatientId(), note.getPhysician(), note.getNote(), note.getPatientName());
//    }
//
//    // GET: /api/patients/history?patientId=5
//    @GetMapping
//    public List<MedicalHistoryNote> getNotes(@RequestParam Long patientId) {
//        log.info("Retrieving notes for Patient ID " + patientId);
//        return service.getNotesForPatient(patientId);
//    }
//}
//

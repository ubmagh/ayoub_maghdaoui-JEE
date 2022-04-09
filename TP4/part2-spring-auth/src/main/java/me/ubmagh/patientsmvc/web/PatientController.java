package me.ubmagh.patientsmvc.web;

import lombok.AllArgsConstructor;
import me.ubmagh.patientsmvc.entities.Patient;
import me.ubmagh.patientsmvc.repositories.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

// web.PatientController
@Controller
@AllArgsConstructor
public class PatientController {

    private PatientRepository patientRepository;

    @GetMapping(path = "/patients")
    public String patients(Model model, @RequestParam(value = "page", defaultValue = "0") int page,
                           @RequestParam(value = "size", defaultValue = "5") int size,
                           @RequestParam(value = "keyword", defaultValue = "") String keyword){
        Page<Patient> patientList = patientRepository.findByNomContains( keyword, PageRequest.of(page, size));
        model.addAttribute("patients", patientList.getContent() );
        int[] pages ;
        if( patientList.getTotalPages()>5 ) {
            pages = new int[5];
            if( page<=3 ){
                for(int i=0; i<5; i++)
                    pages[i]=i;
            }else{
                int j =0;
                if( page>= ( patientList.getTotalPages()-2 )){
                    for(int i=patientList.getTotalPages()-5; i<patientList.getTotalPages(); i++)
                        pages[j++]=i;
                }else{
                    for(int i=page-2; i<(page+3); i++)
                        pages[j++]=i;
                }
            }
        }else {
            pages = new int[patientList.getTotalPages()];
            for(int i=0; i<patientList.getTotalPages(); i++)
                pages[i]=i;
        }
        model.addAttribute("pages", pages );
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("keyword", keyword);
        model.addAttribute("maxPages", patientList.getTotalPages());
        return "patients";
    }

    @GetMapping( path = "/delete")
    public String delete( Long id, @RequestParam(defaultValue = "") String keyword,
                          @RequestParam(defaultValue = "0") int page,
                          @RequestParam(defaultValue = "5") int size){
        patientRepository.deleteById(id);
        return "redirect:/patients?page="+page+"&keyword="+keyword+"&size="+size;
    }

    @GetMapping( path = "/")
    public String index( ){
        return "index";
    }

    @GetMapping( path = "/new")
    public String newPatient( Model model ){
        model.addAttribute("patient", new Patient());
        return "formPatient";
    }

    // il fallait séparer les deux save fontions pour ajout/modification
    @PostMapping( path = "/save")
    public String save(Model model, @Valid Patient patient, BindingResult bindingResult,
                       @RequestParam(defaultValue = "") String keyword,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "5") int size){
        if(bindingResult.hasErrors())
            return "formPatient";
        patientRepository.save(patient);
        // model.addAttribute("status", "ANY"); // notify that the patient was successfully saved
        return "redirect:/patients?page="+page+"&keyword="+keyword+"&size="+size;
    }

    @PostMapping( path = "/put")
    public String put(Model model, @Valid Patient patient, BindingResult bindingResult,
                       @RequestParam(defaultValue = "") String keyword,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "5") int size){
        if(bindingResult.hasErrors())
            return "formEditPatient";
        patientRepository.save(patient);
        // model.addAttribute("status", "ANY"); // notify that the patient was successfully saved
        return "redirect:/patients?page="+page+"&keyword="+keyword+"&size="+size;
    }

    @GetMapping( path = "/edit")
    public String editPatient( Model model, Long id, String keyword, int page, int size ){
        Patient p = patientRepository.findById(id).orElse(null);
        if( p==null )
            throw new RuntimeException("Patient introuvable !");
        model.addAttribute("patient", p );
        model.addAttribute("size", size );
        model.addAttribute("page", page );
        model.addAttribute("keyword", keyword );
        return "formEditPatient";
    }
}

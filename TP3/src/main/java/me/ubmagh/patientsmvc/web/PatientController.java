package me.ubmagh.patientsmvc.web;

import lombok.AllArgsConstructor;
import me.ubmagh.patientsmvc.entities.Patient;
import me.ubmagh.patientsmvc.repositories.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

// web.PatientController
@Controller
@AllArgsConstructor
public class PatientController {

    private PatientRepository patientRepository;

    @GetMapping(path = "/index")
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
    public String delete( Long id, String keyword, int page, int size){
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword+"&size="+size;
    }

    @GetMapping( path = "/")
    public String index( ){
        return "redirect:/index";
    }
}

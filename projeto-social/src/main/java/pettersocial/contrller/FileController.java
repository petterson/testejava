package pettersocial.contrller;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import pettersocial.model.Pessoa;
import pettersocial.repository.Pessoas;
import pettersocial.service.FileService;

@Controller
public class FileController {

    @Autowired
    FileService fileService;
    ModelAndView modelAndView;
    @Autowired
	private Pessoas pessoas;
    Path copyLocation;
    

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {
    	fileService.uploadFile(file);
    	copyLocation = Paths.get(fileService.uploadDir + File.separator + file.getOriginalFilename());
        Type collectionType = new TypeToken<ArrayList<Pessoa>>(){}.getType();
        Reader reader = new FileReader(fileService.uploadDir + File.separator + file.getOriginalFilename());
    	Gson gson = new Gson();
        ArrayList<Pessoa> ps = gson.fromJson(reader, collectionType);
    	//ps.forEach(System.out::println);
    	for(int i=0; i< ps.size(); i++) {
    		Pessoa p = ps.get(i);
    		try {
    			pessoas.save(p);
    			}catch (IllegalArgumentException e) {
    				
    				e.getMessage().formatted("merda");
    			}
    	}
        redirectAttributes.addFlashAttribute("message",
            "You successfully uploaded " + file.getOriginalFilename() + "!");
        return "redirect:/mostrajson";
    }
    
    @GetMapping("/mostrajson")
	public ModelAndView listar(RedirectAttributes re) {
		 this.modelAndView = new ModelAndView("Mostrajson");
		return modelAndView;
	}
	
}

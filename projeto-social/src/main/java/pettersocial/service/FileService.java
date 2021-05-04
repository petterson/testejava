package pettersocial.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import execeptions.FileStorageException;
import pettersocial.model.Pessoa;
import pettersocial.repository.Pessoas;

@Service
public class FileService {

    @Value("${app.upload.dir:${user.home}}")
    public String uploadDir;
    @Autowired
	private Pessoas pessoas;
    //public Path copyLocation;

    public void uploadFile(MultipartFile file) {

        try {
            //Path copyLocation = "/home/sueder";
              Path copyLocation = Paths.get(uploadDir + File.separator + file.getOriginalFilename());
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FileStorageException("Could not store file " + file.getOriginalFilename()
                + ". Please try again!");
        }
    }
    
	
	public ArrayList<Pessoa> findAll() {
        var users = new ArrayList<Pessoa>();
        return users;
    }
	
	public Long contador() {
        return pessoas.count();
    }
	
	public ArrayList<String> getListEstado(){	
		return pessoas.findAllEstado();
	}
	
     public ArrayList<String> getListEstadoDistinct(){	
		return pessoas.findAllDistinctEstado();
	}
     
     public ArrayList<Pessoa> getListPessoas(){
    	return pessoas.findAllPessoa();
     }
}

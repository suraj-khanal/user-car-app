package com.spring.usercarapp.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spring.usercarapp.entity.UserSignup;
import com.spring.usercarapp.repository.SignupRepository;

@Controller
public class UserProfileController {
	
	@Autowired
	private SignupRepository signupRepository;
	
	
	@GetMapping("/showUserDetails")
    public String showUserInfo(Model model,HttpSession session ) {
		
		String authenticatedUsername = (String) session.getAttribute("username");
		
		if (authenticatedUsername != null) {
			
			List<UserSignup> userList = signupRepository.findByUsername(authenticatedUsername);
			
			if (!userList.isEmpty()) {
				
			    UserSignup user = userList.get(0);
			    
			    model.addAttribute("userdata", user);
			    
			    return "userprofile";
			    
			}
			
			 else {
				    model.addAttribute("error", "User not found");
				    return "login";
			}
		
        } 
		else {
        	
            model.addAttribute("error", "User not found");
            
            return "login";
        }
    }
	
	@GetMapping("/changeProfileImage")
    public String showChangeProfileForm() {
		
        return "changeProfileImageForm"; 
	}
	
	@PostMapping("/changeProfileImage")
    public String changeProfilePicture(@RequestParam("imageFile") MultipartFile imageFile, HttpSession session, Model model) {
        
		if (!imageFile.isEmpty()) {
			
            try {
                String authenticatedUsername = (String) session.getAttribute("username");
                List<UserSignup> userSignupList = signupRepository.findByUsername(authenticatedUsername);

                if (!userSignupList.isEmpty()){
                	
                    UserSignup user = userSignupList.get(0);
                    
                    String strProfileImage = Base64.getEncoder().encodeToString(imageFile.getBytes());
                    
                    user.setUserProfileImage(strProfileImage);

                    signupRepository.save(user);
                    
                    model.addAttribute("userData", user);
                    model.addAttribute("userProfileChangeImgMsg", "User Profile Image Changed Successfully!!");

                    return "redirect:/showUserDetails";
                }
            } catch (IOException e) {
                
                e.printStackTrace();
                
            }
        }

        return "redirect:/changeProfileImage"; 
    }
	
}

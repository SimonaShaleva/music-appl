package com.example.music_appl.web;

import com.example.music_appl.model.binding.AlbumAddBindingModel;
import com.example.music_appl.model.service.AlbumServiceModel;
import com.example.music_appl.model.service.UserServiceModel;
import com.example.music_appl.service.AlbumService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("albums")
public class AlbumController {

    private final AlbumService albumService;
    private final ModelMapper modelMapper;

    public AlbumController(AlbumService albumService, ModelMapper modelMapper) {
        this.albumService = albumService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("add")
    public String addAlbum(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("user") == null) {
            return redirectHome();
        }

        if (!model.containsAttribute("albumAddBindingModel")) {
            model.addAttribute(new AlbumAddBindingModel());
        }
        return "add-album";
    }

    @PostMapping("add")
    public String addAlbumPost(@Valid AlbumAddBindingModel albumAddBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("albumAddBindingModel", albumAddBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.albumAddBindingModel", bindingResult);

            return redirectAddAlbum();
        }

        albumAddBindingModel.setAddedFrom((UserServiceModel) httpSession.getAttribute("user"));

        AlbumServiceModel albumServiceModel = modelMapper.map(albumAddBindingModel, AlbumServiceModel.class);

        albumService.addAlbum(albumServiceModel);
        return redirectHome();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        albumService.deleteById(id);

        return redirectHome();

    }

    private String redirectAddAlbum() {
        return "redirect:add";
    }

    private String redirectHome() {
        return "redirect:/";
    }
}

package com.example.its.web.issue;

import com.example.its.domain.issue.IssueEntity;
import com.example.its.domain.issue.IssueService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/issues")
public class IssueController {

    private final IssueService issueService;

    //GET /issues
    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("issueList", issueService.findAll());
        return "issues/list";
    }


    @GetMapping("/creationForm")
    public String showCreationForm(@ModelAttribute IssueForm issueForm) {
        return "issues/creationForm";
    }

    @PostMapping("")
    public String create(@Validated IssueForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) return showCreationForm(form);
        issueService.create(form.getSummary(), form.getDescription());
        return "redirect:/issues";
    }

    // GET localhost:8080/issues/{issueId}
    @GetMapping("/{issueId}")
    public String showDetail(@PathVariable("issueId") long issueId, Model model) {
        model.addAttribute("issue", issueService.findById(issueId));
        return "issues/detail";
    }
}

package com.edwardjones.magicnumber.view.mainviewtopmenu;

import com.edwardjones.magicnumber.view.education.EducationView;
import com.edwardjones.magicnumber.view.rewards.RewardsView;
import com.google.common.base.Strings;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.BlurNotifier;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.ViewNavigators;
import io.jmix.flowui.app.main.StandardMainView;
import io.jmix.flowui.component.UiComponentUtils;
import io.jmix.flowui.component.radiobuttongroup.JmixRadioButtonGroup;
import io.jmix.flowui.component.textarea.JmixTextArea;
import io.jmix.flowui.kit.component.ComponentUtils;
import io.jmix.flowui.kit.component.button.JmixButton;
import io.jmix.flowui.view.Subscribe;
import io.jmix.flowui.view.ViewComponent;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

@Route("")
@ViewController(id = "magic_MainViewTopMenu")
@ViewDescriptor(path = "main-view-top-menu.xml")
public class MainViewTopMenu extends StandardMainView
{
    @Autowired
    private ViewNavigators viewNavigators;
    
    @ViewComponent
    private ProgressBar progressBar;
    
    @ViewComponent
    private JmixRadioButtonGroup<Object> answer2RadioButtons;
    
    @Subscribe
    public void onInit(final InitEvent event)
    {
        answer2RadioButtons.setItems("Overwhelmed", "Stressed", "Curious", "Doing Ok", "Confident");
    }
    
    @Subscribe("answer2RadioButtons")
    public void onAnswer2RadioButtonsComponentValueChange(
        final AbstractField.ComponentValueChangeEvent<JmixRadioButtonGroup<String>, String> event)
    {
        progressBar.setValue(progressBar.getValue() + 0.2);
    }
    
    @Override
    protected void updateTitle()
    {
        super.updateTitle();
        
        String viewTitle = getTitleFromOpenedView();
        UiComponentUtils.findComponent(getContent(), "viewHeaderBox")
                        .ifPresent(component -> component.setVisible(!Strings.isNullOrEmpty(viewTitle)));
    }
    
    @Subscribe(id = "educationButton", subject = "clickListener")
    public void onEducationButtonClick(final ClickEvent<JmixButton> event)
    {
        viewNavigators.view(this, EducationView.class).navigate();
    }
    
    @Subscribe("answer1")
    public void onAnswer1Blur(final BlurNotifier.BlurEvent<JmixTextArea> event)
    {
        progressBar.setValue(progressBar.getValue() + 0.2);
    }
    
    @Subscribe("answer3")
    public void onAnswer3Blur(final BlurNotifier.BlurEvent<JmixTextArea> event)
    {
        progressBar.setValue(progressBar.getValue() + 0.1);
    }
    
    @Subscribe("answer4")
    public void onAnswer4Blur(final BlurNotifier.BlurEvent<JmixTextArea> event)
    {
        progressBar.setValue(progressBar.getValue() + 0.1);
    }
}
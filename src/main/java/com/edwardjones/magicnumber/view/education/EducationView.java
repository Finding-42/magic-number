package com.edwardjones.magicnumber.view.education;

import com.edwardjones.magicnumber.view.mainviewtopmenu.MainViewTopMenu;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.ViewNavigators;
import io.jmix.flowui.kit.component.button.JmixButton;
import io.jmix.flowui.view.StandardView;
import io.jmix.flowui.view.Subscribe;
import io.jmix.flowui.view.ViewComponent;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import com.vaadin.flow.component.html.IFrame;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "education-view", layout = MainViewTopMenu.class)
@ViewController(id = "magic_EducationView")
@ViewDescriptor(path = "education-view.xml")
public class EducationView extends StandardView
{
    @ViewComponent
    private IFrame videoIframe1;

    @ViewComponent
    private IFrame videoIframe2;
    
    @Autowired
    private ViewNavigators viewNavigators;
    
    @Subscribe
    public void onInit(final InitEvent event)
    {
        videoIframe1.setSrc("https://www.youtube.com/embed/zx5eCltU5sY?si=32ex0ah2JMQDG5XQn");
        videoIframe2.setSrc("https://www.youtube.com/embed/2z6JARlOcRQ?si=MdoB_vY4Cozug5xG");
    }
    
    @Subscribe(id = "returnButton", subject = "clickListener")
    public void onReturnButtonClick(final ClickEvent<JmixButton> event)
    {
        viewNavigators.view(this, MainViewTopMenu.class).navigate();
    }
}
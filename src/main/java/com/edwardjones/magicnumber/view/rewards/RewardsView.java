package com.edwardjones.magicnumber.view.rewards;

import com.edwardjones.magicnumber.view.mainviewtopmenu.MainViewTopMenu;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.ViewNavigators;
import io.jmix.flowui.kit.component.button.JmixButton;
import io.jmix.flowui.view.StandardView;
import io.jmix.flowui.view.Subscribe;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.View;

@Route(value = "rewards-view", layout = MainViewTopMenu.class)
@ViewController(id = "magic_RewardsView")
@ViewDescriptor(path = "rewards-view.xml")
public class RewardsView extends StandardView
{
    @Autowired
    private View view;
    @Autowired
    private ViewNavigators viewNavigators;
    
    @Subscribe(id = "ReturnToMainButton", subject = "clickListener")
    public void onReturnToMainButtonClick(final ClickEvent<JmixButton> event)
    {
       viewNavigators.view(this, MainViewTopMenu.class).navigate(); 
    }
}
package com.edwardjones.magicnumber.view.mainviewtopmenu;

import com.edwardjones.magicnumber.view.rewards.RewardsView;
import com.google.common.base.Strings;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.ViewNavigators;
import io.jmix.flowui.app.main.StandardMainView;
import io.jmix.flowui.component.UiComponentUtils;
import io.jmix.flowui.kit.component.button.JmixButton;
import io.jmix.flowui.view.Subscribe;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

@Route("")
@ViewController(id = "magic_MainViewTopMenu")
@ViewDescriptor(path = "main-view-top-menu.xml")
public class MainViewTopMenu extends StandardMainView
{
    @Autowired
    private ViewNavigators viewNavigators;
    
    @Override
    protected void updateTitle()
    {
        super.updateTitle();
        
        String viewTitle = getTitleFromOpenedView();
        UiComponentUtils.findComponent(getContent(), "viewHeaderBox")
                        .ifPresent(component -> component.setVisible(!Strings.isNullOrEmpty(viewTitle)));
    }
    
    @Subscribe(id = "rewardsButton", subject = "clickListener")
    public void onRewardsButtonClick(final ClickEvent<JmixButton> event)
    {
        viewNavigators.view(this, RewardsView.class).navigate();
    }
}
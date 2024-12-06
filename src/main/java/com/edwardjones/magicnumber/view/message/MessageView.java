package com.edwardjones.magicnumber.view.message;

import com.edwardjones.magicnumber.view.mainviewtopmenu.MainViewTopMenu;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.StandardView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "message-view", layout = MainViewTopMenu.class)
@ViewController(id = "magic_MessageView")
@ViewDescriptor(path = "message-view.xml")
public class MessageView extends StandardView
{
}
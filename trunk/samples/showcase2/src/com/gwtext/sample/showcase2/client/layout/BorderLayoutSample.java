/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client.layout;

import com.gwtext.client.core.Margins;
import com.gwtext.client.core.RegionPosition;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.BorderLayoutData;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class BorderLayoutSample extends ShowcasePanel {

	public String getSourceUrl() {
		return "source/layout/BorderLayoutSample.java.html";
	}

	public Panel getViewPanel() {
		if (panel == null) {

			panel = new Panel();
			panel.setLayout(new FitLayout());

			Panel borderPanel = new Panel();
			borderPanel.setLayout(new BorderLayout());

			//add north panel
			Panel northPanel = new Panel();
			northPanel.setHtml("<p>north panel</p>");
			northPanel.setHeight(32);
			northPanel.setBodyStyle("background-color:#FFFF88");
			borderPanel.add(northPanel, new BorderLayoutData(RegionPosition.NORTH));

			//add south panel
			Panel southPanel = new Panel();
			southPanel.setHtml("<p>south panel</p>");
			southPanel.setHeight(100);
			southPanel.setBodyStyle("background-color:#CDEB8B");
			southPanel.setCollapsible(true);
			southPanel.setTitle("South");

			BorderLayoutData southData = new BorderLayoutData(RegionPosition.SOUTH);
			southData.setMinSize(100);
			southData.setMaxSize(200);
			southData.setMargins(new Margins(0, 0, 0, 0));
			southData.setSplit(true);
			borderPanel.add(southPanel, southData);

			//add east panel
			Panel eastPanel = new Panel();
			eastPanel.setHtml("<p>east panel</p>");
			eastPanel.setTitle("East Side");
			eastPanel.setCollapsible(true);
			eastPanel.setWidth(225);

			BorderLayoutData eastData = new BorderLayoutData(RegionPosition.EAST);
			eastData.setSplit(true);
			eastData.setMinSize(175);
			eastData.setMaxSize(400);
			eastData.setMargins(new Margins(0, 0, 5, 0));

			borderPanel.add(eastPanel, eastData);

			Panel westPanel = new Panel();
			westPanel.setHtml("<p>west panel</p>");
			westPanel.setTitle("West");
			westPanel.setBodyStyle("background-color:#EEEEEE");
			westPanel.setCollapsible(true);
			westPanel.setWidth(200);

			BorderLayoutData westData = new BorderLayoutData(RegionPosition.WEST);
			westData.setSplit(true);
			westData.setMinSize(175);
			westData.setMaxSize(400);
			westData.setMargins(new Margins(0, 5, 0, 0));

			borderPanel.add(westPanel, westData);

			Panel centerPanel = new Panel();
			centerPanel.setHtml("<p>center panel</p>");
			centerPanel.setBodyStyle("background-color:#C3D9FF");

			borderPanel.add(centerPanel, new BorderLayoutData(RegionPosition.CENTER));

			panel.add(borderPanel);
		}
		return panel;
	}
}
/*
 * GWT-Ext Widget Library
 * Copyright 2007 - 2008, GWT-Ext LLC., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
 
package com.gwtext.sample.showcase2.client.combo;

import com.gwtext.client.core.Template;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.sample.showcase2.client.SampleData;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class ComboBoxStyledSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/combo/ComboBoxStyledSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            final Store store = new SimpleStore(new String[]{"abbr", "country"}, SampleData.getCountries());
			store.load();

			final Template template = new Template("<div class=\"x-combo-list-item\"><img src=\"images/flags/{abbr}.gif\"> " +
                    "{country}<div class=\"x-clear\"></div></div>");


            ComboBox cb = new ComboBox();
            cb.setMinChars(1);
            cb.setFieldLabel("Countries");
            cb.setStore(store);
            cb.setDisplayField("country");
            cb.setMode(ComboBox.LOCAL);
            cb.setTriggerAction(ComboBox.ALL);
            cb.setEmptyText("Select Country");
            cb.setTypeAhead(true);
            cb.setSelectOnFocus(true);
            cb.setWidth(200);
            cb.setResizable(true);
            cb.setTpl(template);
            cb.setTitle("Countries");

            FormPanel form = new FormPanel();
			form.setLabelWidth(70);
			form.setBorder(false);
            form.add(cb);

            panel.add(form);
        }
        return panel;
    }

    public String getIntro() {
        return "<p>In this sample the entries in the ComboBox dropdown are styled using a simple but " +
                "powerful templating mechanism and can be customized to meet the users requirements.</p>" +
                "<p>Also notice that in this example resizing of the dropdown is enabled using a simple ComboBox setting.</p>";
    }
}
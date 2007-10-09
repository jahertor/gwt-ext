/*
 * GwtExt - Gwt Ext Integration library.
 *
 * Copyright (c) 2007, Sanjiv Jivan
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */

package com.gwtext.client.widgets.form;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.EventObject;

//http://extjs.com/forum/showthread.php?t=3613&highlight=triggerfield
public abstract class TriggerField extends TextField {

    public TriggerField() {
        setJsObj(create(null));
        setup(this, jsObj);
    }

    public TriggerField(TriggerFieldConfig config) {
        super(config);
        setup(this, jsObj);
    }

    private native void setup(TriggerField triggerField, JavaScriptObject jsObj) /*-{
        jsObj.onTriggerClick = function(event) {
            var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
            triggerField.@com.gwtext.client.widgets.form.TriggerField::onTriggerClick(Lcom/gwtext/client/core/EventObject;)(e);
        }
    }-*/;
    
    protected native JavaScriptObject create(JavaScriptObject jsObj) /*-{
        return new $wnd.Ext.form.TriggerField(jsObj);
    }-*/;

    protected abstract void onTriggerClick(EventObject event);
}
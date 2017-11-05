/******************************************************************************
 * Copyright (c) 2017 Assemblits contributors                                 *
 *                                                                            *
 * This file is part of Dynamo: Dynamic JavaFX control objects                *
 * by Assemblits Organization.                                                *
 *                                                                            *
 * Dynamo: Dynamic JavaFX control objects is free software: you can           *
 * redistribute it and/or modify it under the terms of the GNU General        *
 * Public License as published by the Free Software Foundation, either        *
 * version 3 of the License, or (at your option) any later version.
 *                                                                            *
 * Dynamo is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of             *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the              *
 * GNU General Public License for more details.                               *
 *                                                                            *
 * You should have received a copy of the GNU General Public License          *
 * along with Foobar.  If not, see <http://www.gnu.org/licenses/>.            *
 ******************************************************************************/
package org.assemblits.dynamo.control;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import org.assemblits.dynamo.control.skin.AlarmSkin;

public class Alarm extends Control {
    /* ********** Fields ********** */
    private final BooleanProperty   currentValue;
    private final StringProperty    name;


    /* ********** Constructor ********** */
    public Alarm() {
        getStyleClass().add("alarm");
        currentValue                = new BooleanPropertyBase(false) {
            @Override
            public Object getBean() {
                return Alarm.this;
            }
            @Override
            public String getName() {
                return "currentValue";
            }
        };
        name                        = new SimpleStringProperty(Alarm.this, "name", "");
    }


    /* ********** Setters and Getters ********** */
    public boolean getCurrentValue() {
        return currentValue.get();
    }
    public BooleanProperty currentValueProperty() {
        return currentValue;
    }
    public void setCurrentValue(boolean currentValue) {
        this.currentValue.set(currentValue);
    }

    public String getName() {
        return name.get();
    }
    public StringProperty nameProperty() {
        return name;
    }
    public void setName(String name) {
        this.name.set(name);
    }


    /* ********** Style and Skin ********** */
    @Override public String getUserAgentStylesheet() {
        return getClass().getResource("alarm.css").toExternalForm();
    }
    @Override protected Skin<?> createDefaultSkin() {
        return new AlarmSkin(this);
    }

}

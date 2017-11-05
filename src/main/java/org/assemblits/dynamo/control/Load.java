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
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import org.assemblits.dynamo.control.skin.LoadSkin;

public class Load extends Control {

    /* ********** Dynamic Fields ********** */
    private StringProperty name;
    private BooleanProperty energized;


    /* ********** Constructors ********** */
    public Load() {
        getStyleClass().add("load");
        name                = new SimpleStringProperty(this, "name", "");
        energized           = new SimpleBooleanProperty(this, "energized", false);
    }

    /* ********** Setters and Getters ********** */
    public String getName() {
        return name.get();
    }
    public StringProperty nameProperty() {
        return name;
    }
    public void setName(String name) {
        this.name.set(name);
    }

    public boolean getEnergized() {
        return energized.get();
    }
    public BooleanProperty energizedProperty() {
        return energized;
    }
    public void setEnergized(boolean energized) {
        this.energized.set(energized);
    }

    /* ********** Style and Skin ********** */
    @Override public String getUserAgentStylesheet() {
        return  getClass().getResource("load.css").toExternalForm();
    }
    @Override protected Skin<?> createDefaultSkin() {
        return new LoadSkin(this);
    }
}

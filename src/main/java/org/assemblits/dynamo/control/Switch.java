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

import javafx.beans.property.*;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import org.assemblits.dynamo.control.skin.SwitchSkin;

public class Switch extends Control {

    private static final int DEFAULT_ANIMATION_DURATION = 400;

    /* ********** Dynamic Fields ********** */
    private BooleanProperty     animated;
    private IntegerProperty     animationDuration;
    private StringProperty      name;
    private BooleanProperty     energized;
    private BooleanProperty     closed;

    /* ********** Constructors ********** */
    public Switch() {
        getStyleClass().add("switch");
        animated            = new SimpleBooleanProperty(this, "animated", true);
        animationDuration   = new SimpleIntegerProperty(this, "animationDuration", DEFAULT_ANIMATION_DURATION);
        name                = new SimpleStringProperty(this, "name", "NAME");
        energized           = new SimpleBooleanProperty(this, "energized", false);
        closed              = new SimpleBooleanProperty(this, "closed", false);
    }

    /* ********** Setters and Getters ********** */

    public boolean getAnimated() {
        return animated.get();
    }
    public BooleanProperty animatedProperty() {
        return animated;
    }
    public void setAnimated(boolean animated) {
        this.animated.set(animated);
    }

    public int getAnimationDuration() {
        return animationDuration.get();
    }
    public IntegerProperty animationDurationProperty() {
        return animationDuration;
    }
    public void setAnimationDuration(int animationDuration) {
        this.animationDuration.set(animationDuration);
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

    public boolean getEnergized() {
        return energized.get();
    }
    public BooleanProperty energizedProperty() {
        return energized;
    }
    public void setEnergized(boolean energized) {
        this.energized.set(energized);
    }

    public boolean getClosed() {
        return closed.get();
    }
    public BooleanProperty closedProperty() {
        return closed;
    }
    public void setClosed(boolean closed) {
        this.closed.set(closed);
    }

    /* ********** Style and Skin ********** */
    @Override public String getUserAgentStylesheet() {
        return  getClass().getResource("switch.css").toExternalForm();
    }
    @Override protected Skin<?> createDefaultSkin() {
        return new SwitchSkin(this);
    }
}

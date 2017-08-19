/*
 * Copyright (c) 2013 by Gerrit Grunwald
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.hansolo.enzo;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.css.PseudoClass;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import eu.hansolo.enzo.skin.SimpleIndicatorSkin;


/**
 * Created by
 * User: hansolo
 * Date: 06.03.12
 * Time: 13:48
 */
public class SimpleIndicator extends Control {
    private static final PseudoClass ON_PSEUDO_CLASS     = PseudoClass.getPseudoClass("off");
    public static final String       STYLE_CLASS_OFF     = "indicator-off";
    public static final String       STYLE_CLASS_RED     = "indicator-red";
    public static final String       STYLE_CLASS_GREEN   = "indicator-green";
    public static final String       STYLE_CLASS_BLUE    = "indicator-blue";
    public static final String       STYLE_CLASS_YELLOW  = "indicator-yellow";
    public static final String       STYLE_CLASS_ORANGE  = "indicator-orange";
    public static final String       STYLE_CLASS_CYAN    = "indicator-cyan";
    public static final String       STYLE_CLASS_MAGENTA = "indicator-magenta";
    public static final String       STYLE_CLASS_PURPLE  = "indicator-purple";
    public static final String       STYLE_CLASS_GRAY    = "indicator-gray";

    public enum IndicatorStyle {
        OFF(STYLE_CLASS_OFF),
        RED(STYLE_CLASS_RED),
        GREEN(STYLE_CLASS_GREEN),
        BLUE(STYLE_CLASS_BLUE),
        YELLOW(STYLE_CLASS_YELLOW),
        ORANGE(STYLE_CLASS_ORANGE),
        CYAN(STYLE_CLASS_CYAN),
        MAGENTA(STYLE_CLASS_MAGENTA),
        PURPLE(STYLE_CLASS_PURPLE),
        GRAY(STYLE_CLASS_GRAY);

        public final String CLASS;

        private IndicatorStyle(final String CLASS_NAME) {
            CLASS = CLASS_NAME;
        }
    }

    private IndicatorStyle _indicatorStyle = IndicatorStyle.OFF;
    private ObjectProperty<IndicatorStyle> indicatorStyle;
    private BooleanProperty                on;


    // ******************** Constructors **************************************
    public SimpleIndicator() {
        getStyleClass().add("indicator");
        on = new BooleanPropertyBase(false) {
            @Override protected void invalidated() { pseudoClassStateChanged(ON_PSEUDO_CLASS, get()); }
            @Override public Object getBean() { return this; }
            @Override public String getName() { return "on"; }
        };
    }


    // ******************** Methods *******************************************
    public final IndicatorStyle getIndicatorStyle() {
        return null == indicatorStyle ? _indicatorStyle : indicatorStyle.get();
    }
    public final void setIndicatorStyle(final IndicatorStyle INDICATOR_STYLE) {
        if (null == indicatorStyle) {
            _indicatorStyle = INDICATOR_STYLE;
        } else {
            indicatorStyle.set(INDICATOR_STYLE);
        }
    }
    public final ObjectProperty<IndicatorStyle> indicatorStyleProperty() {
        if (null == indicatorStyle) {
            indicatorStyle = new SimpleObjectProperty<>(this, "indicatorStyle", _indicatorStyle);
        }
        return indicatorStyle;
    }

    public final boolean isOn() {
        return on.get();
    }
    public final void setOn(final boolean ON) {
        on.set(ON);
    }
    public final BooleanProperty onProperty() {
        return on;
    }
    

    // ******************** Style related *************************************
    @Override protected Skin createDefaultSkin() {
        return new SimpleIndicatorSkin(this);
    }

    @Override public String getUserAgentStylesheet() {
        return getClass().getResource("simpleindicator.css").toExternalForm();
    }
}

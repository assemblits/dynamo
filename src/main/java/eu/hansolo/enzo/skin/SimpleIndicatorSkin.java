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

package eu.hansolo.enzo.skin;

import javafx.scene.control.Skin;
import javafx.scene.control.SkinBase;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import eu.hansolo.enzo.SimpleIndicator;


/**
 * Created by
 * User: hansolo
 * Date: 06.03.12
 * Time: 13:53
 */
public class SimpleIndicatorSkin extends SkinBase<SimpleIndicator> implements Skin<SimpleIndicator> {
    private static final double PREFERRED_SIZE = 48;
    private static final double MINIMUM_SIZE   = 16;
    private static final double MAXIMUM_SIZE   = 1024;
    private double              size;
    private Pane                pane;
    private Region              outerFrame;
    private Region              innerFrame;
    private Region              mainBack;
    private Region              main;
    private Region              highlight;


    // ******************** Constructors **************************************
    public SimpleIndicatorSkin(){
        super(new SimpleIndicator());
    }

    public SimpleIndicatorSkin(final SimpleIndicator CONTROL) {
        super(CONTROL);        

        init();
        initGraphics();
        registerListeners();
    }


    // ******************** Initialization ************************************
    private void init() {
        if (Double.compare(getSkinnable().getPrefWidth(), 0.0) <= 0 || Double.compare(getSkinnable().getPrefHeight(), 0.0) <= 0 ||
            getSkinnable().getWidth() <= 0 || getSkinnable().getHeight() <= 0) {
            getSkinnable().setPrefSize(PREFERRED_SIZE, PREFERRED_SIZE);
        }

        if (Double.compare(getSkinnable().getMinWidth(), 0.0) <= 0 || Double.compare(getSkinnable().getMinHeight(), 0.0) <= 0) {
            getSkinnable().setMinSize(MINIMUM_SIZE, MINIMUM_SIZE);
        }

        if (Double.compare(getSkinnable().getMaxWidth(), 0.0) <= 0 || Double.compare(getSkinnable().getMaxHeight(), 0.0) <= 0) {
            getSkinnable().setMaxSize(MAXIMUM_SIZE, MAXIMUM_SIZE);
        }
    }

    private void initGraphics() {
        outerFrame = new Region();
        outerFrame.getStyleClass().setAll("outer-frame");

        innerFrame = new Region();
        innerFrame.getStyleClass().setAll("inner-frame");

        mainBack = new Region();
        mainBack.getStyleClass().setAll("main-back");

        main = new Region();
        main.getStyleClass().setAll("main");

        highlight = new Region();
        highlight.getStyleClass().setAll("highlight");

        pane = new Pane();
        pane.getChildren().setAll(outerFrame, innerFrame, mainBack, main, highlight);

        getChildren().setAll(pane);
    }

    private void registerListeners() {
        getSkinnable().widthProperty().addListener(observable -> handleControlPropertyChanged("RESIZE") );
        getSkinnable().heightProperty().addListener(observable -> handleControlPropertyChanged("RESIZE") );
        getSkinnable().indicatorStyleProperty().addListener(observable -> handleControlPropertyChanged("UPDATE") );
        getSkinnable().onProperty().addListener(observable -> handleControlPropertyChanged("ON"));
    }


    // ******************** Methods *******************************************
    protected void handleControlPropertyChanged(final String PROPERTY) {
        if ("RESIZE".equals(PROPERTY)) {
            resize();
        } else if ("UPDATE".equals(PROPERTY)) {
            update();
        } else if ("ON".equals(PROPERTY)) {
            if (getSkinnable().isOn()) {
                update();
            } else {
                getSkinnable().getStyleClass().setAll("indicator", SimpleIndicator.STYLE_CLASS_OFF);
            }
        }
    }
    

    // ******************** Private Methods ***********************************
    private void update() {
        getSkinnable().getStyleClass().setAll("indicator", getSkinnable().getIndicatorStyle().CLASS);
    }

    private void resize() {
        size = getSkinnable().getWidth() < getSkinnable().getHeight() ? getSkinnable().getWidth() : getSkinnable().getHeight();

        if (size > 0) {
            pane.setMaxSize(size, size);
            
            outerFrame.setPrefSize(size, size);

            innerFrame.setPrefSize(size * 0.8, size * 0.8);
            innerFrame.setTranslateX((size - innerFrame.getPrefWidth()) * 0.5);
            innerFrame.setTranslateY((size - innerFrame.getPrefHeight()) * 0.5);

            mainBack.setPrefSize(size * 0.76, size * 0.76);
            mainBack.setTranslateX((size - mainBack.getPrefWidth()) * 0.5);
            mainBack.setTranslateY((size - mainBack.getPrefHeight()) * 0.5);

            main.setPrefSize(size * 0.76, size * 0.76);
            main.setTranslateX((size - main.getPrefWidth()) * 0.5);
            main.setTranslateY((size - main.getPrefHeight()) * 0.5);

            highlight.setPrefSize(size * 0.52, size * 0.30);
            highlight.setTranslateX((size - highlight.getPrefWidth()) * 0.5);
            highlight.setTranslateY((size - highlight.getPrefHeight()) * 0.2);
        }
    }
}

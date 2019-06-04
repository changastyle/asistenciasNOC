<div class="col-xs-12 sin-padding">
    <div class="col-xs-6 sin-padding-left">
        
        <!-- PROVINCIA: -->
        <div class="form-group">
            <label>Provincia</label>
            
            <!-- COMBO PROVINCIA: -->
            <div class="ui fluid search selection dropdown">
            <input name="country" ng-model="provinciaSelected">
                <i class="dropdown icon" ></i>
                <div class="default text">
                    Seleccionar Provincia
                </div>
                <div class="menu">
                    <div class="item" data-value="{{provincia.id}}" ng-repeat="provincia in arrProvincias" ng-click="seleccionarProvincia(provincia)">
                        <i class="af flag"></i>
                        {{provincia.nombre}}
                    </div>
                </div>
            </div>
            
            {{provinciaSelected}}

        </div>
        
    </div>
    <div class="col-xs-6 sin-padding-left">
    
        <!-- PERSONA: -->
        <div class="form-group">
            <label>Persona</label>

            <!-- COMBO PROVINCIA: -->
            <div class="ui fluid search selection dropdown">
            <input name="country" ng-model="provinciaSelected">
                <i class="dropdown icon" ></i>
                <div class="default text">
                    Seleccionar Persona
                </div>
                <div class="menu">
                    <div class="item" ng-repeat="persona in arrPersonas" ng-click="seleccionarPersona(persona)">
                        <i class="af flag"></i>
                        {{persona.nombre}}
                    </div>
                </div>
            </div>
            
            <!--
            <select id="combo-personas" class='form-control' ng-change="changeComboPersonas()" ng-model='personaSelected' list="browsers">
                <datalist id="browsers">
                    <option ng-value="persona.nombre" ng-repeat="persona in arrPersonas">
                </datalist>
            </select>-->
                <!--ng-options="persona as persona.nombre for persona in arrPersonas">
                <option value="{{persona}}" ng-repeat="persona in arrPersonas">{{persona.nombre}}</option>
            </select>-->
            <br>
            {{personaSelected}}
        </div>
    </div>
</div>
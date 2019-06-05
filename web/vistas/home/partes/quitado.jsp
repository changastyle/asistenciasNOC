 <!--HORA-->
            <div class="form-group">
                <label>Incio Consulta</label>
                {{horaInicio | date:'HH:mm:ss'}}
                <br>
                <label>Incio Consulta</label>{{horaFin | date:'HH:mm:ss'}}
                <br>
                <button class="btn btn-default" ng-click="cerrarTimer()">Iniciar Timer</button>
                <button class="btn btn-default" ng-click="changeComboPersonas()">combo</button>
            </div>
        </div>
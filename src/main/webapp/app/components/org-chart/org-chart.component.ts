import Component from 'vue-class-component';
import { Prop, Vue } from 'vue-property-decorator';
import OrgChart from '@balkangraph/orgchart.js'

@Component({
    components: {
        OrgChart
    }
})
export default class OrgChartComponent extends Vue {
    @Prop()
    nodes: any;
    public chart: any;

    public mounted(): void {
        console.log(this.nodes);
        this.oc(this.$refs.tree, this.nodes)
    }
    public oc(domEl, x) {
        this.chart = new OrgChart(domEl, {
            nodes: x,
            nodeBinding: {
                field_0: "name",
                field_1: "title",
            }
        });
    }
}

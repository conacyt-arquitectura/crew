import Component from 'vue-class-component';
import { Prop, Vue } from 'vue-property-decorator';
import BModal from 'bootstrap-vue';
@Component
export default class ActionButtonsComponent extends Vue {
    @Prop()
    editView: string;

    @Prop()
    detailsView: string;

    @Prop()
    params: any;

    public get detailsParams() {
        return { name: this.detailsView, params: this.params };
    }
    public get editParams {
        return { name: this.editView, params: this.params };
    }
    public previousState(): void {
        this.$router.go(-1);
    }

    public cancel(): void {
        this.$emit('onCancel');
    }
}

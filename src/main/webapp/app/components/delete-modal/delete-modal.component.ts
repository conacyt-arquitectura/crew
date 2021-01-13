import Component from 'vue-class-component';
import { Prop, Vue } from 'vue-property-decorator';
import BModal from 'bootstrap-vue';
@Component
export default class DeleteModalComponent extends Vue {
    @Prop({ default: 'removeEntity' })
    id: string;

    public closeModal(): void {
        this.$bvModal.hide(this.id);
    }

    public remove(): void {
        this.$emit('onDelete');
    }
}

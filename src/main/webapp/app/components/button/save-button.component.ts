import Component from 'vue-class-component';
import { Prop, Vue } from 'vue-property-decorator';

@Component
export default class SaveButtonComponent extends Vue {
    @Prop()
    saving: boolean;

    @Prop()
    enabled: boolean;

}

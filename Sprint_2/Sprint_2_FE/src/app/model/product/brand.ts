import {Watch} from "./watch";

export interface Brand {
  id?: number;
  name?: string;
  origin?: string;
  brandImgUrl?: string;
  deleteStatus?: boolean;
  watches?: Watch;
}

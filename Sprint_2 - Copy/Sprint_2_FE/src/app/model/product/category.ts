import {Watch} from "./watch";

export interface Category {
  id: string;
  name: string;
  deleteStatus?: boolean;
  watches?: Watch;
}

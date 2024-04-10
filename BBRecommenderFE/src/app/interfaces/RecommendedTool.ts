import { FilterOptions } from "./FilterOptions";
import { ToolInfo } from "./ToolInfo";

export interface RecommendedTool {
    id?: number; // optional field
    uid: string;
    creator: string;
    date: string;
    toolName: string;
    companyName: string;
    filterOptions: FilterOptions;
    toolInfo?: ToolInfo; // optional field
}
export class FilterbarValues {

    readonly yesNoQuestion = [  { name: "Yes",value: true  }, 
                                { name: "No", value: false } 
                             ];

    readonly features = ["Email marketing", "Social media integration",
                        "A/B testing", "Leadscoring", "CRM integration",
                        "Transactional Emails","Lead generation",
                        "Reporting","Custom Data Objects", "Landings pages"];

    readonly levelOfSupport = ["Basic: Email support, Live chat", "Standard: Basic + 24/7 support","Advanced: Standard + Personalized support"];

    readonly dbQuality = ["Low complexity", "Moderate complexity", "High complexity"];

    readonly dragAndDrop = ["Point & click", "Limited drag & drop", "Drag & drop"];

    readonly implementationModel = ["Inhouse", "Outsourced"];

}
package tilingTypes.NC5.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_51a
   extends TilingType
{
   public TilingTypeNC5_51a(){
      super( "NC5-51a", 5, SymmetryType.pgg );

      paramMin = new int[]{   0,  0,  0,  0 };
      paramMax = new int[]{  90,100,100,100 };
      paramDef = new int[]{  40, 75, 70, 40 };
      paramName = new String[]{ "Angle", "Skew", "Length", "Indentation" };
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 4,3, 0,3,4, 0},
            {0, 0,1, 0,1,2, 1},
            {0, 4,3, 2,3,4, 1},
      };
      info = "b=c\nD+E=360\n(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double anAOB = paramValues[0];
      double minlnOB = 2 * Math.cos(anAOB * DEG2RAD);
      minlnOB = 2/(minlnOB+1);
      double lnOA = (2-minlnOB) * paramValues[1]/100.;
      double lnOB = 2-lnOA;
      double lnAE = lnOA*paramValues[2]/100.;
      double lnAB = calcSide(lnOA, lnOB, anAOB);
      double lnBC = lnAB;
      double anEAB = calcAngle(lnOA, lnAB, lnOB);
      double anABC = 180-anEAB-anAOB;

      double f = 3/(lnAE+lnAB+lnBC);
      lnAE *=f;
      lnAB *=f;
      lnBC *=f;

      double maxindent =  Math.sin(anABC*DEG2RAD) * lnBC / Math.sin(anEAB*DEG2RAD);
      maxindent = Math.min(maxindent, lnAE);
      double lnCD = maxindent*paramValues[3]/100.;
      lnAE -= lnCD;
      
      double xA = 0;
      double yA = 0;
      double xB = lnAB * Math.cos( (90-anAOB/2-anEAB) * DEG2RAD);
      double yB = lnAB * Math.sin( (90-anAOB/2-anEAB) * DEG2RAD);
      double xC = xB + lnBC * Math.cos( (90+anAOB/2) * DEG2RAD);
      double yC = yB + lnBC * Math.sin( (90+anAOB/2) * DEG2RAD);
      double xD = xC - lnCD * Math.cos( (90-anAOB/2) * DEG2RAD);
      double yD = yC - lnCD * Math.sin( (90-anAOB/2) * DEG2RAD);
      double xE = lnAE * Math.cos( (90-anAOB/2) * DEG2RAD);
      double yE = lnAE * Math.sin( (90-anAOB/2) * DEG2RAD);

      baseTile.setPoint(0, xA, yA);
      baseTile.setPoint(1, xB, yB);
      baseTile.setPoint(2, xC, yC);
      baseTile.setPoint(3, xD, yD);
      baseTile.setPoint(4, xE, yE);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(0)-tiles[1].getX(1);
      offsets[1] = tiles[3].getY(0)-tiles[1].getY(1);
      offsets[2] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(2)-tiles[0].getY(0);
   }
}

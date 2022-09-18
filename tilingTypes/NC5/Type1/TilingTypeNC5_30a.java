package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_30a
   extends TilingType
{
   public TilingTypeNC5_30a(){
      super( "NC5-30a", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,100,100};
      paramDef = new int[]{ 30, 40, 50};
      paramName = new String[]{ "Base", "Teeth", "Side" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,0, 0,0,2, 0},
            {1, 1,2, 0,2,1, 0},
            {1, 1,2, 1,2,1, 0},
      };
      info = "a=d\nD+E=360\nA=D\n(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln4 = 3. * getParam(paramValues,0) / 100; // base+teeth
      double sides = 3. - ln4;
      double mintooth = Math.max(ln4-sides, 0);
      double ln3 = mintooth + (ln4-mintooth) * getParam(paramValues,1) / 100; // tooth
      double base = ln4-ln3;
      double minside = Math.max((sides-base)/2, 0);
      double maxside = (sides+base)/2;
      double ln2 = minside + (maxside-minside) * getParam(paramValues,2) / 100; // side
      double diag = sides - ln2;

      // calc angles
      double ang = calcAngle(base,diag,ln2);
      double ln1 = calcSide(ln3,diag/2,180-ang);
      double b = calcAngle(ln3,ln1,diag/2);

      double x4 =      ln1 * Math.cos( b * DEG2RAD);
      double y4 =      ln1 * Math.sin( b * DEG2RAD);
      double x3 = x4 - ln3;
      double y3 = y4;
      double x2 = x3 + x4;
      double y2 = y3 + y4;
      double x1 = ln4;
      double y1 = 0;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(4)-tiles[3].getX(0);
      offsets[1] = tiles[2].getY(4)-tiles[3].getY(0);
      offsets[2] = tiles[2].getX(3)-tiles[3].getX(2);
      offsets[3] = tiles[2].getY(3)-tiles[3].getY(2);
   }
}

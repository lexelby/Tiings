package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_65
   extends TilingType
{
   public TilingTypeNC5_65(){
      super( "NC5-65", 5, SymmetryType.pg );

      paramMin = new int[]{   0};
      paramMax = new int[]{ 100};
      paramDef = new int[]{  70};
      paramName = new String[]{ "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,0, 0,3,2, 1},
            {1, 1,0, 0,4,0, 0},
            {1, 4,0, 2,2,3, 1},
      };
      info = "a=d\nc=e\nb=a+c\nA=60\nB=60\nD=300\n(C+E=120)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .4;
      double ln1 = ln + ln*getParam( paramValues,0)/100.;
      double ln2 = 3*ln-ln1;
      double s60 = Math.sqrt(3)/2;
      double ln3 = calcSide(ln1,ln2,60);
      double an = calcAngle(ln1,ln3,ln2);

      double dx = ln1 * Math.cos((60-2*an) * DEG2RAD);
      double dy = ln1 * Math.sin((60-2*an) * DEG2RAD);
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln1+ln2,  0);
      baseTile.setPoint(2, ln1/2+ln2, ln1*s60);
      baseTile.setPoint(3, ln2/2 + dx, ln2*s60 + dy);
      baseTile.setPoint(4, ln2/2, ln2*s60);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(3)-tiles[0].getX(1);
      offsets[1] = tiles[1].getY(3)-tiles[0].getY(1);
      offsets[2] = tiles[0].getX(2)-tiles[3].getX(1);
      offsets[3] = tiles[0].getY(2)-tiles[3].getY(1);
   }
}
